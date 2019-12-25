<template>
    <v-form>
        <v-container>
            <v-row>

                <v-col cols="12" sm="6" md="3">
                    <v-text-field
                            label="ISBN"
                            v-model="isbn"
                    ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6" md="3">
                    <v-text-field
                            label="personalName"
                            v-model="personalName"
                    ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6" md="3">
                    <v-text-field
                            label="bookNumber"
                            v-model="bookNumber"
                    ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6" md="5">
                    <v-btn @click="orderBook()">OrderBook</v-btn>
                </v-col>
                <v-col>
                    <v-btn v-if="showResult" @click="taken()">ISBN {{isbn}} Book Reservation Taken for {{personalName}}
                    </v-btn>
                </v-col>
            </v-row>

        </v-container>

    </v-form>
</template>


<script>
    import api from "./backend-api";

    export default {
        name: "OrderBookWindow",
        return: {},
        data: {
            isbn: '',
            personalName: '',
            bookNumber: '',
            showResult: false,
        },
        methods: {
            orderBook() {

                api.orderbook(this.personalName, this.isbn, this.bookNumber).then(r => {
                    this.showResult = true
                    console.log("Added")
                    this.$forceUpdate()

                }).catch(error => {
                    this.showResult = false
                    console.log("Not Added")
                    this.$forceUpdate()

                })
            },
            taken() {
                this.showResult = false
                this.$forceUpdate()
            }

        },

    }

</script>

<style scoped>

</style>