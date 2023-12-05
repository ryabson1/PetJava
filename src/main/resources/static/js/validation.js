function validateForm() {
  console.log("good")
  var userName = document.getElementById("userName").value;
  var userPwd = document.getElementById("userPwd").value;
  if (userName === "" || userPwd === "") {
    document.getElementById("error-message").innerText = "Please";
    return false; // Остановить отправку формы
  }

  return true; // Продолжить отправку формы
}