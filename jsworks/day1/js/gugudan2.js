function showGugudan() {
  const result = document.getElementById("result");
  const input = document.getElementById("dan").value;

  if (input.trim() === "") {
    result.textContent = "숫자를 입력해주세요.";
    return;
  }

  if (isNaN(input)) {
    result.textContent = "유효한 숫자가 아닙니다.";
    return;
  }

  const dan = parseInt(input);
  result.innerHTML = `<h3>${dan}단</h3>`;

  for (let i = 1; i <= 9; i++) {
    result.innerHTML += `${dan} x ${i} = ${dan * i}<br>`;
  }
}
