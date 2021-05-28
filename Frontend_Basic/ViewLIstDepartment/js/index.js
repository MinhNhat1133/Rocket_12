$(function () {
  $(".header").load("header.html");
  $(".main").load("home.html");
  $(".footer").load("footer.html");
});

function clickNavHome() {
  $(".main").load("home.html");
}

function clickNavViewDepartments() {
  $(".main").load("main.html");
  buildTable();
}

var departments = [];
var counter = 0;

function departmment(Department, NumberofEmployee) {
  this.id = ++counter;
  this.Department = Department;
  this.NumberofEmployee = NumberofEmployee;
}

function initDepartments() {
  $.get(
    "https://60a913fa20a6410017306ae1.mockapi.io/department",
    function (data, status) {
      departments = data;

      departments.forEach(function (item) {
        $("tbody").append(
          "<tr>" +
            "<td>" +
            item.Department +
            "</td>" +
            "<td>" +
            item.NumberofEmployee +
            "</td>" +
            "<td>" +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal(' +
            item.id +
            ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onClick="openConfirmDelete(' +
            item.id +
            ')"><i class="material-icons">&#xE872;</i></a>' +
            "</td>" +
            "</tr>"
        );
      });
    }
  );
}

function buildTable() {
  setTimeout(function name(params) {
    $("tbody").empty();
    initDepartments();
  }, 500);
}

function openAddModal() {
  //resetForm();
  openModal();
}

function resetForm() {
  document.getElementById("id").val = "";
  document.getElementById("Department").val = "";
  document.getElementById("NumberofEmployee").val = "";
}

function openModal() {
  $("#myModal").modal("show");
}

function hideModal() {
  $("#myModal").modal("hide");
}

function addDepartment() {
  var DepartmentValue = document.getElementById("Department").value;
  var NumberofEmployeeValue = document.getElementById("NumberofEmployee").value;

  var department = {
    Department: DepartmentValue,
    NumberofEmployee: NumberofEmployeeValue,
  };
  $.post(
    "https://60a913fa20a6410017306ae1.mockapi.io/department",
    department,
    function (data, status) {
      hideModal();
      showSuccessAlert();
      buildTable();
    }
  );
}

function openUpdateModal(id) {
  openModal();
  var index = departments.findIndex((x) => x.id == id);

  document.getElementById("id").value = departments[index].id;
  document.getElementById("Department").value = departments[index].Department;
  document.getElementById("NumberofEmployee").value =
    departments[index].NumberofEmployee;

  openModal();
}

function save() {
  var id = document.getElementById("id").value;

  if (id == null || id == "") {
    addDepartment();
  } else {
    updateDepartment();
  }
}

function updateDepartment() {
  var id = document.getElementById("id").value;
  var DepartmentValue = document.getElementById("Department").value;
  var NumberofEmployeeValue = document.getElementById("NumberofEmployee").value;

  var department = {
    Department: DepartmentValue,
    NumberofEmployee: NumberofEmployeeValue,
  };

  $.ajax({
    type: "PUT",
    url: "https://60a913fa20a6410017306ae1.mockapi.io/department/" + id,
    data: department,

    success: function (result) {
      hideModal();
      showSuccessAlert();
      buildTable();
    },
  });
}

function openConfirmDelete(id) {
  var index = departments.findIndex((x) => x.id == id);
  var Department = departments[index].Department;

  var result = confirm("Bạn có chắc muốn xóa " + Department + "?");
  if (result) {
    deleteDepartment(id);
  }
}

function deleteDepartment(id) {

  $.ajax({
    type: "DELETE",
    url: "https://60a913fa20a6410017306ae1.mockapi.io/department/" + id,
    success: function (result) {
      if (result == undefined || result == null) {
        alert("Lỗi khi load data");
        return;
      }
      showSuccessAlert();
      buildTable();
    },
  });
}

function showSuccessAlert() {
  $("#success-alert")
    .fadeTo(2000, 500)
    .slideUp(500, function () {
      $("#success-alert").slideUp(500);
    });
}
