<template>
    <div>
        <v-col cols="12" sm="6" md="3">
            <v-text-field
                    label="username"
                    v-model="user.username"
            ></v-text-field>
        </v-col>

        <v-col cols="12" sm="6" md="3">
            <v-text-field
                    label="password"
                    v-model="user.password"
            ></v-text-field>
        </v-col>

        <v-col cols="12" sm="6" md="5">
            <v-btn @click="addUser()">Add Book TO Database</v-btn>
        </v-col>
    </div>
</template>

<script>
    export default {
        name: "LoginWindow",
        data: {
            user: {
                username: '',
                password: '',
            }
        }
    }
</script>

<style scoped>

</style>