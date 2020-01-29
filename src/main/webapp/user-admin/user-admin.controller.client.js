(function () {


    let users = [];


    var $usernameFld;
    var $passwordFld = $("#passwordFld");
    var $removeBtn = $("wbdv-remove");
    var $editBtn = $("wbdv-edit");
    var $createBtn;
    var $firstNameFld = $("#firstnameFld");
    var $lastNameFld = $("#lastNameFld");
    var $roleFld= $("#roleFld");
    var $userRowTemplate = $(".wbdv-template");
    var $tbody = $(".wbdv-tbody");
    var userService = new AdminUserServiceClient();
    $(main);


    function createUser() {
        const newUser = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()

        }
        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $roleFld.val("");


        userService.createUser(newUser)
            .then((actualUser) => {
                 users.push(actualUser)
                 renderUsers()
                findAllUsers()
            })
    }
    function findAllUsers() {
        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers()
            })
    }
    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(theusers => {
                users = theusers
                renderUsers()
            })
    }
    function deleteUser(index) {
        let user = users[index]
        let userId = user._id

        userService.deleteUser(userId)
            .then(response => {
                users.splice(index, 1)
                renderUsers()
            })
    }
    function selectUser() {}



    function updateUser() {
        const updatedUser = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()
        }
        $usernameFld.val("")
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $roleFld.val("");

        updatedUser._id = users[currentUserIndex]._id

        userService.updateUser(updatedUser._id, updatedUser)
            .then((actualUser) => {
                findAllUsers()
            })
    }
    function renderUser(user) {}
    function renderUsers() {
        $tbody.empty()
        for (let u in users) {
            let user = users[u];
            // $remove.click(() => deleteUser(u))

            $removeBtn = $("<button> Delete</button>")
            $removeBtn.click(() => deleteUser(u))

            $editBtn = $("<button> Edit</button>")
            $editBtn.click(() => updateUser(u))


            const rowClone = $userRowTemplate.clone();
            rowClone.removeClass('wbdv-hidden');
            rowClone.find('.wbdv-username').html(user.username);
            //rowClone.find('.wbdv-password').html(user.password);
            rowClone.find('.wbdv-first-name').html(user.firstName);
            rowClone.find('.wbdv-last-name').html(user.lastName);
            rowClone.find('.wbdv-role').html(user.role);

            $tbody.append(rowClone);

            $tbody.append($removeBtn);
            $tbody.append($editBtn);

        }
    }

    function main() {

        $usernameFld = $("#usernameFld");
        $createBtn = $("#createBtn");

        $createBtn.click(createUser)
        //$updateBtn.click(updateUser)

        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers()

            })

    }
})()
