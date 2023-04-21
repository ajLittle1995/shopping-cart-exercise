function doupload() {
    let data = document.getElementById("file").files[0];
    let entry = document.getElementById("file").files[0];
    console.log('doupload',entry,data)

  const reader = new FileReader();
  reader.addEventListener('load', (event) => {
    const text = event.target.result;
    console.log(text);
   fetch('http://localhost:8080/calculateReceipt', {
       method: 'POST',
       headers: {
           'Accept': 'application/json',
           'Content-Type': 'application/json'
       },
       body: text
   })
      .then(response => response.json())
  });
  reader.readAsText(data);

};
