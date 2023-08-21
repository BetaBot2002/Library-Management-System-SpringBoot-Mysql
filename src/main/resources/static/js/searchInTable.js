const searchInput = document.getElementById('searchInput');
const table = document.getElementById('myTable');
const rows = table.getElementsByTagName('tr');

searchInput.addEventListener('keyup', function() {
  const filter = searchInput.value.toLowerCase();

  for (let i = 1; i < rows.length; i++) {
    const row = rows[i];
    const firstName = row.getElementsByTagName('td')[1].innerHTML.toLowerCase();

    if (firstName.indexOf(filter) ===0) {
      row.style.display = '';
    } else {
      row.style.display = 'none';
    }
  }
});