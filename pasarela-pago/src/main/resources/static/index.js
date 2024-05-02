const mp =  new MercadoPago('APP_USR-c7db783f-1369-4182-a19a-a8e70be3d28f',{
    locale: 'es-CO'

});

const MP = async ()=>{
    try{
        miArticulo = {}
        miArticulo.title='Seguro Premium';
        miArticulo.quantity = 1;
        miArticulo.unit_price = 200000;


        const  response = await fetch("/api/mp",{
            method: 'POST',
            headers:{
                'Accept': 'Application/json',
                'Content-Type': 'Application/json'
            },
            body: JSON.stringify(miArticulo)
        })
        const preference = await response.text()
        createCheckoutButton(preference)
    }catch(e){alert("error: "+ e)}
}

const createCheckoutButton = (preferenceId_OK)=>{
    const bricksBuilder = mp.bricks();
    const generateButton = async () =>{
        if(window.checkoutButton) window.checkoutButton.unmount()
        bricksBuilder.create("wallet", "wallet_container", {
            initialization: {
                preferenceId: preferenceId_OK,
            },
        });
    }
    generateButton()
}


