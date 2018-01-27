var app = new Vue({
    el: '#vue',
    data: {
        users: []
    },
    created: function () {
        var self = this;
        axios.get('http://localhost:8080/users')
            .then(function(response) {
                self.users = response.data;
            })
            .catch(function (error) {
                console.log(error);
            });
    }
})
