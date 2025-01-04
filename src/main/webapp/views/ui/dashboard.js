const username = 'Ajay';
const password = 'vijay@123';
const authHeader = 'Basic ' + btoa(`${username}:${password}`);

function showAboutDiv(){
    
    console.log('about-div');
    document.getElementById('contact-page').style.display='none';
    document.getElementById('about-page').style.display='flex';
    document.getElementById('product-page').style.display='none';

}

function showContactDiv(){
    console.log('contact-div');
    document.getElementById('about-page').style.display='none';
    document.getElementById('contact-page').style.display='flex';
    document.getElementById('product-page').style.display='none';
}

function showProductContainerDiv(){
    console.log('product div');
    document.getElementById('about-page').style.display='none';
    document.getElementById('contact-page').style.display='none';
    document.getElementById('product-page').style.display='flex';
    
    fetch('http://localhost:8080/getAllProducts',{
        method: 'GET',
        headers: {
          'Authorization': authHeader, 
          'Content-Type': 'application/json',
        },})
    .then((response)=> response.json())
    .then((data)=>displayProduct(data))
    .catch((error)=>console.log('Error fetching products :'+error));
}

function displayProduct(product){
    const productContainer=document.getElementById('product-page');
    product.forEach((product) => {
        const productCard=document.createElement('div');
        productCard.id='product-card';
        
        const image =document.createElement('img');
        image.src=product.imageUrl;
        image.alt=product.productName;
        
        const productNameTag=document.createElement('h3');
        productNameTag.textContent=product.productName;

        const productPriceTag=document.createElement('p');
        productPriceTag.textContent=product.price;

        const productMaterialTag=document.createElement('p');
        productMaterialTag.textContent=product.material;

        const productAvlQtyTag=document.createElement('p');
        productAvlQtyTag.textContent=product.availabilityQty;

        productCard.appendChild(image);
        productCard.appendChild(productNameTag);
        productCard.appendChild(productPriceTag);
        productCard.appendChild(productMaterialTag);
        productCard.appendChild(productAvlQtyTag);

        productContainer.appendChild(productCard);
    });
}

function showProductCategoryContainerDiv(){
    console.log('product div');
    document.getElementById('about-page').style.display='none';
    document.getElementById('contact-page').style.display='none';
    document.getElementById('product-page').style.display='flex';
    
    fetch('http://localhost:8080/getAllProductcategories',{
        method: 'GET',
        headers: {
          'Authorization': authHeader, 
          'Content-Type': 'application/json',
        },})
    .then((response)=> response.json())
    .then((data)=>displayProduct(data))
    .catch((error)=>console.log('Error fetching products :'+error));
}


