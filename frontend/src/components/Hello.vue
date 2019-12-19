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
    import AddBookWindow from "./AddBookWindow";
    import BasketWindow from "./BasketWindow";
    import LoginWindow from "./LoginWindow";
    import OrderBookWindow from "./OrderBookWindow";
    import SearchBookWindow from "./SearchBookWindow";
    import User from "./User";

    export default {
        name: "Hello",
        components: {User, SearchBookWindow, OrderBookWindow, LoginWindow, BasketWindow, AddBookWindow},
    }
</script>

<style scoped>

</style>