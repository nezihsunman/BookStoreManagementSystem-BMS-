<template>
    <div>
        <AddBookWindow></AddBookWindow>
        <BasketWindow></BasketWindow>
        <LoginWindow></LoginWindow>
        <OrderBookWindow></OrderBookWindow>
        <SearchBookWindow></SearchBookWindow>
    </div>
</template>

<script>
    import api from "./backend-api";

    import AddBookWindow from "./AddBookWindow";
    import OrderBookWindow from "./OrderBookWindow";
    import SearchBookWindow from "./SearchBookWindow";

    export default {
        name: 'hello',
        components: {SearchBookWindow, OrderBookWindow, AddBookWindow},
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