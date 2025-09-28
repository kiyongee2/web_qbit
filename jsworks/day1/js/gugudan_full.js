function showGugudan() {
  const result = document.getElementById("result");

  let table = "<table>";
  table += "<tr>";
  for (let dan = 2; dan <= 9; dan++) {
    table += `<th>${dan}단</th>`;
  }
  table += "</tr>";

  for (let i = 1; i <= 9; i++) {
    table += "<tr>";
    for (let dan = 2; dan <= 9; dan++) {
      table += `<td>${dan} x ${i} = ${dan * i}</td>`;
    }
    table += "</tr>";
  }

  table += "</table>";
  result.innerHTML = table;
}
