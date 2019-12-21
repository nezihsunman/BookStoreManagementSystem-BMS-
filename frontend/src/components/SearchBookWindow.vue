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
        <v-btn @click="addBasket()">Reservation of One Book</v-btn>
        <v-btn class="justify-content-end" @click="takeDataFromDb()">Take data from db</v-btn>


    </v-card>
</template>


<script>

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
                basketTable: []
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
            takeDataFromDb() {
                this.refreshDataTable()
            },

        }
    }
</script>

<style scoped>

</style>