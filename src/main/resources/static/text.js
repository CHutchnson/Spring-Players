"use strict";

const ADDR = "http://localhost:8080";

// Divs
const RESULTS_DIV = document.querySelector("#results-div");
const FORM_DIV = document.querySelector("#form-div");
const MODAL_FOOTER = document.getElementById("footer");
const SAVE = document.createElement("button");


// Get request
const getAll = () => {
    axios.get(`${ADDR}/player/getAll`)
        .then((resp) => {

            RESULTS_DIV.innerHTML = "";
            const RESULTS = resp.data;

            for (let result of RESULTS) {
                printResult(result);
            }

        }).catch((err) => console.error(err))
}

document.querySelector("div#form-div > form").addEventListener('submit', (e) => {
    e.preventDefault();

    const form = e.target;

    const data = {
        username: form.name.value,
        email: form.mail.value
}

    console.log("Data: ", data);

    // Post request
        axios.post(`${ADDR}/player/create`, data)
        .then((resp) => {
            console.log(resp);
            getAll();

            form.reset();

        }).catch((err) => console.error(err));
    
})

const update = (id) => {

    const info = {
        username: document.getElementById('eFormUsername').value,
        email: document.getElementById('eFormEmail').value
}

    console.log("Info: ", info);

    axios.put(`${ADDR}/player/update/${id}`, info).then((resp) => {
        console.log(resp);
        console.log("successfully updated! ");
        getAll();

    }).catch((err) => console.error(err))
 
}




// Delete request
const del = (id) => {
    axios.delete(`${ADDR}/player/delete/${id}`)
    .then((resp) => {
        console.log(resp);
        getAll();

    }).catch((err) => console.error(err))
    
}

const statusMsg = (bool) => {

}

const printResult = (result) => {

    const ENTRY_DIV = document.createElement("div");
    ENTRY_DIV.setAttribute("class", "entry-div");

    const ENTRY = document.createElement("div");
    ENTRY.setAttribute("class", "entry");

    const MODAL_FOOTER_DIV = document.createElement("div");
    MODAL_FOOTER_DIV.setAttribute("class", "modal_div");


    const VALUES = document.createElement("div");
    VALUES.setAttribute("class", "entry-values");
    VALUES.textContent = `${result.id} |  ${result.username} | ${result.email}`;
    

    const EDIT = document.createElement("button");
    EDIT.type = "button";
    EDIT.textContent = "Edit";
    EDIT.id = `${result.id}`;
    EDIT.setAttribute("class", "btn btn-sm btn-primary edit-btn");
    EDIT.setAttribute("onClick", "openEdit(this.id)");

    const DEL = document.createElement("button");
    DEL.type = "button";
    DEL.textContent = "Delete";
    DEL.id = `${result.id}`;
    DEL.setAttribute("class", "btn btn-sm btn-danger del-btn");
    DEL.setAttribute("onClick", "del(this.id)");

    ENTRY.appendChild(VALUES);
    ENTRY_DIV.appendChild(ENTRY);
    

    ENTRY_DIV.appendChild(EDIT);
    ENTRY_DIV.appendChild(DEL);

    RESULTS_DIV.appendChild(ENTRY_DIV);
}



const validateForm = (type) => {

}

const openEdit = (id) => {
    // Show modal and configure date field
    $("#edit-modal").modal("show");

    // Get the current values for selected entry
    axios.get(`${ADDR}/player/getById/${id}`)
        .then((resp) => {
            const ENTRY = resp.data;

            MODAL_FOOTER.appendChild(SAVE);
            SAVE.id = `${ENTRY.id}`;
            SAVE.setAttribute("onClick", "update(this.id)");
            SAVE.type = "button";
            SAVE.textContent = "Save";
            SAVE.setAttribute("class", "btn btn-primary");

            // Populate modal form with current values
            const EDIT_FORM = document.forms["editForm"];
            EDIT_FORM["entry-id"].value = ENTRY.id;
            EDIT_FORM["username"].value = ENTRY.username;
            EDIT_FORM["email"].value = ENTRY.email;


        }).catch((err) => console.error(err))
}

//find a way to define the id as the id of the current user you are editing 
//var id = document.getElementById(editForm.entry-id.value);
//SAVE.setAttribute("onClick", "update((id))");
// Put request

//SAVE.setAttribute("onClick", "update(this.id");

//document.querySelector("div#form-div > editForm").addEventListener('save-changes-btn', (e) => {
   // e.preventDefault();

