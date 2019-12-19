<template>
    <v-form>
        <v-container>
            <v-row>
                <v-col cols="12" sm="6" md="3">
                    <v-text-field
                            label="bookLabel"
                            v-model="bookName"
                    ></v-text-field>
                </v-col>
                <v-col cols="12" sm="6" md="5">
                    <v-btn @click="confirmButton()">Confirm Button</v-btn>
                </v-col>
            </v-row>
        </v-container>
    </v-form>
</template>

<script>
    export default {
        name: "BasketWindow",
        methods: {
            confirmButton() {
                console.log("confirm")
            }
        }
    }
</script>

<style scoped>

</style>