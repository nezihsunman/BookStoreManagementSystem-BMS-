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
		
    }
</script>

<style scoped>

</style>