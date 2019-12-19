<template>
    <div>
        <v-app>
            <v-app-bar
                    app
                    color="primary"
                    dark
            > Book Store Management System
            </v-app-bar>

            <v-content>
                <router-view/>
            </v-content>
        </v-app>
    </div>
</template>

<script>

    export default {
        name: 'App',

        data: () => ({
            //
        }),
    };
</script>
