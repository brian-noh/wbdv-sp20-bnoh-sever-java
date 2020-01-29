function User(username, password, firstName, lastName, role) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;

    this.setUsername = setUsername;
    this.getUsername = getUsername;

    this.setPassword = setPassword;
    this.getPassword = getPassword;

    this.setFirstName = setFirstName;
    this.getFirstName = getFirstName;

    this.setLastName = setLastName;
    this.getLastName = getLastName;

    this.setRole = setRole;
    this.getRole = getRole;


    function setUsername(username) {
        this.username = username;
    }
    function getUsername() {
        return this.username;
    }

    function setPassword(password) {
        this.password = password;
    }
    function getPassword() {
        return this.password;
    }

    function setFirstname(firstName) {
        this.firstName = firstName;
    }
    function getFirstname() {
        return this.fristName;
    }

    function setLastname(lastName) {
        this.lastName = lastName;
    }
    function getLastname() {
        return this.lastNAme;
    }

    function setRole(role) {
        this.role = role;
    }
    function getRole() {
        return this.role;
    }


}
