import axios from 'axios'

const AXIOS = axios.create({
    baseURL: `/api`,
    timeout: 1000
});


export default {
    hello() {
        return AXIOS.get(`/hello`);
    },

    getUser(userId) {
        return AXIOS.get(`/user/` + userId);
    },
    createUser(firstName, lastName) {
        return AXIOS.post(`/user/` + firstName + '/' + lastName);
    },
    getSecured(user, password) {
        return AXIOS.get(`/secured/`, {
            auth: {
                username: user,
                password: password
            }
        });
    },
    addbook(firstName, ISBN, bookType, date, publishDate, price, booknumber) {
        return AXIOS.post('savebook/' + firstName + '/' + ISBN + '/' +
            bookType + '/' + date + '/' + publishDate + '/' + price + '/' + booknumber
        )
    },
    changeBookNumber(ISBN) {
        return AXIOS.post('changeBookNumber/' + ISBN)
    },
    getTableData() {
        return axios({
                method: 'get',
                url: '/api/takeBookData',
                responsetype: 'json'
            }
        )
    },
    getBookByISBN(ISBN) {
        return AXIOS.post('takeBookByISBN/' + ISBN)

    }
}