<template>
    <v-card>
        <v-card-title>
            Book Search For All Book in Database
            <v-spacer></v-spacer>
            <v-text-field
                    v-model="search"
                    append-icon="search"
                    label="Search"
                    single-line
                    hide-details
                    item-key="name"
            ></v-text-field>
        </v-card-title>
        <v-data-table class="justify-content-center"
                      v-model="selected"
                      :headers="headers"
                      :items="tableData"
                      :items-per-page="20"
                      :search="search"
                      show-select
                      :single-select="singleSelect"
                      item-key="isbn"


        >
        </v-data-table>
        <v-btn @click="addBasket()">Add Selected To Basket</v-btn>
        <v-btn class="justify-content-end" @click="takeDataFromDb()">Take data from db</v-btn>

        <v-dialog v-model="dialogShown" persistent max-width="900">
            <template v-slot:activator="{ on }">
                <v-btn color="primary" dark v-on="on">Basket Window</v-btn>
            </template>
            <v-card>
                <v-card-title class="headline">Basket Of Book</v-card-title>
                <v-card-text>This is your basket to add to reservation
                </v-card-text>
                <v-card-actions>
                    <v-row>
                        <v-col cols="12" sm="12" md="12">
                            <v-data-table class="justify-content-center"
                                          v-model="selected"
                                          :headers="headers"
                                          :items="basketTable"
                                          :items-per-page="20"
                                          :search="search"
                                          item-key="isbn"


                            >

                            </v-data-table>
                        </v-col>
                        <v-spacer></v-spacer>
                        <v-col class="align-center" cols="12" sm="12" md="12">
                            <v-btn color="primary" text @click="closeDialog()">Return</v-btn>
                            <v-btn color="error" text   @click="complateReservation()">Complate Reservation</v-btn>
                            <v-btn color="primary" :disabled="true" readonly="true" >Total Price is {{basketTableTotalPrice}}</v-btn>
                        </v-col>
                    </v-row>

                </v-card-actions>
            </v-card>
        </v-dialog>

    </v-card>

</template>

<script>
    import api from "./backend-api";

    export default {
        name: "SearchBookWindow",
        data() {
            return {
                selected: [],
                search: '',
                singleSelect: true,
                headers: [
                    {
                        text: 'Books',
                        align: 'left',
                        sortable: true,
                        value: 'bookName',
                    },
                    {text: 'BookType (String)', value: 'bookType'},

                    {text: 'Publish (date)', value: 'publishDate'},
                    {text: 'ISBN', value: 'isbn'},
                    {text: 'Version (date)', value: 'versionDate'},
                    {text: 'BookDate (date)', value: 'BookDate'},
                    {text: 'NumberOfBook in BookStore', value: 'booknumber'},
                    {text: 'Price (tl)', value: 'price'},
                ],
                tableData: [],
                dialogShown: false,
                basketTable: [],
                basketTableTotalPrice: 0,
            }
        },
        computed: {
            refreshPageWhileOpening() {
                this.takeDataFromDb();
            }
        },
        watch: {
            selected() {
                if (this.selected[0] != null) {
                    console.log(this.selected[0].isbn)
                }

            },
        },
        methods: {
            addBasket() {
                this.basketTable.push(this.selected[0]);
                this.basketTableTotalPrice=this.basketTableTotalPrice+this.selected[0].price;
            },
            takeDataFromDb() {
                this.refreshDataTable()
            },
            closeDialog() {
                this.dialogShown = false
            },
            deleteOneBook(isbn) {
                api.changeBookNumber(isbn).then(r => {
                    console.log("Deleted")
                }).catch(error => {
                    console.log("Not deleted")
                })

            },
            refreshDataTable() {
                api.getTableData().then(response => {
                    this.tableData = response.data
                }).catch(error => {
                    console.log(error)
                })
                console.log(this.tableData)
            },
            takeBookNumberByISBN(ISBN) {
                api.getBookByISBN(ISBN).then(res => {
                    this.basketTable.push(JSON.stringify(res.data));
                    console.log(JSON.flat(this.basketTable));
                }).catch(err => {
                    console.log(err);
                })
            },
            complateReservation() {
                for (var i = 0; i < this.basketTable.length; i++) {
                    console.log(this.basketTable[i].isbn)
                    this.deleteOneBook(this.basketTable[i].isbn)
                }
                this.dialogShown = false,
                    this.takeDataFromDb()
                this.basketTable = []
            }
        }
    }
</script>

<style scoped>

</style>