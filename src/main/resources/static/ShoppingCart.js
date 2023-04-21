function upload() {
  let data = document.getElementById("file").files[0];
  const reader = new FileReader();
  reader.addEventListener('load', (event) => {
   const text = event.target.result;
   fetch('http://localhost:8080/calculateReceipt', {
       method: 'POST',
       headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
       },
       body: text
   })
      .then(response => response.json())
      .then((data) => {

       const template = document.createElement('div');
       template.innerHTML = JSON.stringify(data).replace(/,/g, '<br>');
       document.body.appendChild(template);
      });
  });
  reader.readAsText(data);
};
