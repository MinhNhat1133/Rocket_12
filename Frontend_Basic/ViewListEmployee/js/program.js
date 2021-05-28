$(function() {
  $(".header").load("header.html");
  $(".main").load("home.html");
  $(".footer").load("footer.html");
});

function clickNavHome() {
  $(".main").load("home.html");
}

function clickNavViewListEmployees() {
  $(".main").load("viewlistemployees.html");
  buildTable();
}

var employees = [];
var counter = 0;

function Employee(name, department, phone) {
  this.id = ++counter;
  this.name = name;
  this.department = department;
  this.phone = phone;
}

function initEmployees() {
  // if (null == employees || employees.length == 0) {
  //     // init data
  //     employees.push(new Employee("John Doe", "Administration", "(171) 555-2222"));
  //     employees.push(new Employee("Peter Parker", "Customer Service", "(313) 555-5735"));
  //     employees.push(new Employee("Fran Wilson", "Human Resources", "(503) 555-9931"));
  // }
  //call API
  $.get("https://60a913fa20a6410017306ae1.mockapi.io/employee",function(data, status) {
      employees = data;
  
      employees.forEach(function(item) {
          $('tbody').append(
              '<tr>' +
              '<td>' + item.name + '</td>' +
              '<td>' + item.department + '</td>' +
              '<td>' + item.phone + '</td>' +
              '<td>' +
              '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
              '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
              '</td>' +
              '</tr>')
      });
   
  });
}

function buildTable() {
  setTimeout(function name(params) {

      $('tbody').empty();
      initEmployees();

     

  }, 500);
}

function openAddModal() {
  //resetForm();
  openModal();
}

function resetForm() {
  document.getElementById("id").val = "";
  document.getElementById("name").val = "";
  document.getElementById("department").val = "";
  document.getElementById("phone").val = "";
}

function openModal() {
  $('#myModal').modal('show');
}

function hideModal() {
  $('#myModal').modal('hide');
}

function addEmployee() {
  var nameValue = document.getElementById("name").value;
  var departmentValue = document.getElementById("department").value;
  var phoneValue = document.getElementById("phone").value;

  // TODO validate
  // then fail validate ==> return;

  // employees.push(new Employee(name, department, phone));

  // hideModal();
  // showSuccessAlert();
  // buildTable();
  var employee={
      name: nameValue,
      department: departmentValue,
      phone: phoneValue
  };
  $.post("https://60a913fa20a6410017306ae1.mockapi.io/employee",employee,function(data, status){
      hideModal();
      showSuccessAlert();
      buildTable();
  });
}

function openUpdateModal(id) {
  openModal();
  // get index from employee's id
  var index = employees.findIndex(x => x.id == id);

  // fill data
  document.getElementById("id").value = employees[index].id;
  document.getElementById("name").value = employees[index].name;
  document.getElementById("department").value = employees[index].department;
  document.getElementById("phone").value = employees[index].phone;

  openModal();
}

function save() {
  var id = document.getElementById("id").value;

  if (id == null || id == "") {
      addEmployee();
  } else {
      updateEmployee();
  }
}

function updateEmployee() {
  var id = document.getElementById("id").value;
  var nameValue = document.getElementById("name").value;
  var departmentValue = document.getElementById("department").value;
  var phoneValue = document.getElementById("phone").value;

  // TODO validate
  // then fail validate ==> return;

  // get index from employee's id
  //var index = employees.findIndex(x => x.id == id);

  // update employee
  // employees[index].name = name;
  // employees[index].department = department;
  // employees[index].phone = phone;

  var employee={
      name: nameValue,
      department: departmentValue,
      phone: phoneValue
  };

  $.ajax({
      type: 'PUT',
      url: 'https://60a913fa20a6410017306ae1.mockapi.io/employee/'+id,
      data: employee,
      
      success: function (result) {
          hideModal();
          showSuccessAlert();
          buildTable();
      }
  });

  
}


function openConfirmDelete(id) {
  // get index from employee's id
  var index = employees.findIndex(x => x.id == id);
  var name = employees[index].name;

  var result = confirm("Want to delete " + name + "?");
  if (result) {
      deleteEmployee(id);
  }
}

function deleteEmployee(id) {
  // TODO validate

  $.ajax({
      type: 'DELETE',
      url: 'https://60a913fa20a6410017306ae1.mockapi.io/employee/'+id,
      success: function (result) {
          //erro
          if(result==undefined || result == null){
              alert("error when loading data");
              return;
          }
          //success
          showSuccessAlert();
          buildTable();
      }
  });
  
  // var index = employees.findIndex(x => x.id === id);
  // employees.splice(index, 1);   
}

function showSuccessAlert() {
  $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
      $("#success-alert").slideUp(500);
  });
}