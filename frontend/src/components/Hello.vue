<template>

    <div v-if="show" class="hello">
        <v-card-text>{{ hellomsg }}</v-card-text>
        <h2>See the sources here: </h2>
        <ul>
            <li><a href="https://github.com/nezihsunman/CS320BOOKSTORE" target="_blank" rel="noopener noreferrer">github.com/nezihsunman/CS320BOOKSTORE</a>
            </li>
        </ul>
        <h3>This site is for CS320 Project</h3>
        <div v-if="loginWindowShow">
            <h3>Please Enter User Name and Role</h3>
            <v-col cols="12" sm="6" md="3">
                <v-text-field
                        label="username"
                        v-model="username"
                ></v-text-field>
            </v-col>

            <v-col cols="12" sm="6" md="5">
                <v-btn @click="getUser()">Give me a Username</v-btn>
            </v-col>
        </div>
        <v-expansion-panels v-if="componentShow" :popout="true">
            <v-expansion-panel>
                <v-expansion-panel-header>AddBookWindow</v-expansion-panel-header>
                <v-expansion-panel-content>
                    <AddBookWindow></AddBookWindow>
                </v-expansion-panel-content>

            </v-expansion-panel>

            <v-expansion-panel>
                <v-expansion-panel-header>Reservation of Book Which is not in DB</v-expansion-panel-header>
                <v-expansion-panel-content>
                    <OrderBookWindow></OrderBookWindow>
                </v-expansion-panel-content>

            </v-expansion-panel>
            <v-expansion-panel>
                <v-expansion-panel-header>SearchBookWindow</v-expansion-panel-header>
                <v-expansion-panel-content>
                    <SearchBookWindow></SearchBookWindow>
                </v-expansion-panel-content>
            </v-expansion-panel>

        </v-expansion-panels>

    </div>

</template>

<script>
    import api from "./backend-api";

    import AddBookWindow from "./AddBookWindow";
    import OrderBookWindow from "./OrderBookWindow";
    import SearchBookWindow from "./SearchBookWindow";

    export default {
        name: 'hello',
        components: {User, SearchBookWindow, OrderBookWindow, AddBookWindow},
        props: {hellomsg: {type: String, required: true}},
        data() {
            return {
                show: true,
                componentShow: false,
                username: '',
                loginWindowShow: true,
                personalName: '',
                booknumber: '',
            }
        },
        methods: {
            getUser() {
                console.log("sss")
                api.getUserName(this.username).then(response => {
                    if (response.data != null) {
                        this.loginWindowShow = false
                        this.componentShow = true
                    }
                }).catch(error => {
                    console.log(error)
                })

            }
        }
    }

</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
