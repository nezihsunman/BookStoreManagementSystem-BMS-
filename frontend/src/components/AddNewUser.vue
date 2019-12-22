<template>
    <div v-if="!addUserShown">

        <v-col cols="12" sm="6" md="3">
            <v-text-field
                    label="UserName"
                    v-model="userlock"
            ></v-text-field>
        </v-col>

        <v-col cols="12" sm="6" md="3">
            <v-text-field
                    label="Pasword"
                    v-model="pasword"
            ></v-text-field>
        </v-col>

        <v-col cols="12" sm="6" md="5">
            <v-btn  @click="lockUser()">Give Password
            </v-btn>
        </v-col>

    </div>
    <div v-else-if="addUserShown">
        <v-form>
            <v-container>
                <v-row>

                    <v-col cols="12" sm="6" md="3">
                        <v-text-field
                                label="UserName"
                                v-model="userName"
                        ></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="6" md="3">
                        <v-text-field
                                label="FirstName"
                                v-model="firstName"
                        ></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="6" md="3">
                        <v-text-field
                                v-model="lastName"
                                label="LastName"
                                solo
                        ></v-text-field>
                    </v-col>
                    <v-col cols="12" sm="6" md="3">
                        <v-text-field
                                v-model="userType"
                                label="UserType"
                                solo
                        ></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="6" md="5">
                        <v-btn :disabled="!userType || !lastName || !firstName || !userName" @click="addUser()">Add
                            Book TO Database
                        </v-btn>
                    </v-col>

                    <button v-if="showResponse" @click="retrieveUser()">Retrieve user {{user.id}} data from database
                    </button>

                    <h4 v-if="showRetrievedUser">Retrieved User {{retrievedUser.firstName}}
                        {{retrievedUser.lastName}}</h4>


                </v-row>
            </v-container>
        </v-form>
    </div>
</template>

<script>
    import api from "./backend-api";

    export default {

        name: "AddBookWindow",

        data() {
            return {
                userName: '',
                firstName: '',
                lastName: '',
                userType: '',
                retrievedUser: {},
                showRetrievedUser: false,
                showResponse: false,
                addUserShown: false,
                userlock:'',
                pasword:''
            }
        }

        ,
        methods: {
            addUser() {
                api.addUser(this.userName, this.firstName, this.lastName, this.userType).then(r => {
                    console.log("Added")
                    this.showResponse = true;
                }).catch(error => {
                    console.log("Not added")
                })
            },
            retrieveUser() {
                api.getUser(this.userName).then(response => {
                    // JSON responses are automatically parsed.
                    this.retrievedUser = response.data;
                    this.showRetrievedUser = true
                })
                    .catch(e => {
                        this.errors.push(e)
                    })
            },
            lockUser() {
                if (this.userlock=='bmstore' && this.pasword=='bmstore') {
                    this.addUserShown=true;
                }
            }
        },
        watch: {}
    }
</script>

<style scoped>

</style>