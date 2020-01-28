(function () {


    let users = [];


    var $usernameFld = $("#usernameFld");
    var $passwordFld = $("#passwordFld");
    var $removeBtn = $("wbdv-remove");
    var $editBtn = $("wbdv-edit");
    var $createBtn = $("wbdv-create");
    var $firstNameFld = $("#firstnameFld");
    var $lastNameFld = $("#lastNameFld");
    var $roleFld= $("#roleFld");
    var $userRowTemplate = $(".wbdv-template");
    var $tbody = $(".wbdv-tbody");
    var userService = new AdminUserServiceClient();
    $(main);


    function createUser() {}
    function findAllUsers() {}
    function findUserById() {}
    function deleteUser() {}
    function selectUser() {}
    function updateUser() {}
    function renderUser(user) {}
    function renderUsers() {
        $tbody.empty()
        for (let u in users) {
            let user = users[u];
            // $remove.click(() => deleteUser(u))

            // $editBtn.click(() => updateUser(u))


            const rowClone = $userRowTemplate.clone();
            rowClone.removeClass('wbdv-hidden');
            rowClone.find('.wbdv-username').html(user.username);
            //rowClone.find('.wbdv-password').html(user.password);
            rowClone.find('.wbdv-first-name').html(user.firstName);
            rowClone.find('.wbdv-last-name').html(user.lastName);
            rowClone.find('.wbdv-role').html(user.role);

            $tbody.append(rowClone);
        }
    }

    function main() {
        userService
            .findAllUsers()
            .then(theusers => {
                users = theusers
                renderUsers()

            })

    }
})()
