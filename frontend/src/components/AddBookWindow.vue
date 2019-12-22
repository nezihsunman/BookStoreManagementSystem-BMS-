<template>
    <v-form>
        <v-container>
            <v-row>

                <v-col cols="12" sm="6" md="3">
                    <v-text-field
                            label="Book Name"
                            v-model="bookName"
                    ></v-text-field>
                </v-col>


                <v-col cols="12" sm="6" md="3">
                    <v-text-field
                            label="ISBN"
                            v-model="isbn"
                    ></v-text-field>
                </v-col>

                <v-col cols="12" sm="6" md="3">
                    <v-text-field
                            v-model="bookType"
                            label="Book Type"
                            solo
                    ></v-text-field>
                </v-col>

                <v-col cols="12" sm="6" md="3">
                    <v-menu
                            v-model="menu2"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            transition="scale-transition"
                            offset-y
                            min-width="290px"
                    >
                        <template v-slot:activator="{ on }">
                            <v-text-field
                                    v-model="date"
                                    label="Picker without buttons"
                                    readonly
                                    v-on="on"
                            ></v-text-field>
                        </template>
                        <v-date-picker v-model="date" @input="menu2 = false"></v-date-picker>
                    </v-menu>
                </v-col>

                <v-col cols="12" sm="6" md="3">
                    <v-menu
                            v-model="menu3"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            transition="scale-transition"
                            offset-y
                            min-width="290px"
                    >
                        <template v-slot:activator="{ on }">
                            <v-text-field
                                    v-model="publishDate"
                                    label="Picker without buttons"
                                    readonly
                                    v-on="on"
                            ></v-text-field>
                        </template>
                        <v-date-picker v-model="publishDate" @input="menu2 = false"></v-date-picker>
                    </v-menu>
                </v-col>

                <v-col cols="12" sm="6" md="3">
                    <v-text-field
                            v-model="price"
                            label="Price Field"
                            solo
                    ></v-text-field>
                </v-col>

                <v-col cols="12" sm="6" md="3">
                    <v-text-field
                            label="booknumber"
                            filled
                            v-model="booknumber"
                    ></v-text-field>
                </v-col>

                <v-col cols="12" sm="6" md="5">
                    <v-btn :disabled="!bookName || !price || !isbn || !bookType || !booknumber" @click="addBook()">Add
                        Book TO Database
                    </v-btn>
                </v-col>


            </v-row>
        </v-container>
    </v-form>
</template>

<script>
    import api from "./backend-api";

    export default {

        name: "AddBookWindow",

        data() {
            return {
                price: '',
                bookName: '',
                bookType: '',
                isbn: '',
                type: '',
                date: '',
                publishDate: '',
                booknumber: ''
            }
        }

        ,
        methods: {
            addBook() {

                console.log("Book Added")
                console.log(this.price)
                console.log(this.bookName)
                api.addbook(this.bookName, this.isbn, this.bookType, new Date("17/06/1997"), new Date("17/06/1997"), 15, 15).then(r => {
                    console.log("Added")
                }).catch(error => {
                    console.log("Not added")
                })
            },
        },
        watch: {}
    }
</script>

<style scoped>

</style>