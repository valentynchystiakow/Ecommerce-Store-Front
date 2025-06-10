// imports packages(libraries)
import { useState, useEffect } from 'react'
import './App.css'
// imports components
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';


// main app component
function App() {
  // creates products state
  const [products, setProducts] = useState([])
  // creates categories state
  const [categories, setCategories] = useState([])
  // creates selectedCategory state with default value of null
  const [selectedCategory, setSelectedCategory] = useState(null)
  // creates searchTerm state with default value of empty string
  const [searchTerm, setSearchTerm] = useState('')
  // creates sortOrder state with default value of 'asc'
  const [sortOrder,setSortOrder] = useState('asc')


  // useEffect - method that runs a piece of code based on a specific condition, fetches data from backend and sets it to the products state and to the categories state
  useEffect(() => {
    fetch ('http://localhost:5454/api/products').then(response => response.json()).then(data => setProducts(data));
    fetch ('http://localhost:5454/api/categories').then(response => response.json()).then(data => setCategories(data));
  } , [])

  // creates handleSearchChange function that updates the searchTerm state
  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  }

  // creates handleSortChange function that updates the sortOrder state
  const handleSortChange = (event) => {
    setSortOrder(event.target.value);
  }

  // creates handleCategorySelect function that updates the selectedCategory state
  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId ? Number(categoryId) : null);
  }

  // creates variable that stores products by selected category and filters products from lower price to higher price or vice versa
  const filteredProducts = products.filter(product => { return ((selectedCategory ? product.category.id === selectedCategory:true) && product.name.toLowerCase().includes(searchTerm.toLowerCase()))
  }).sort((a,b) => {if (sortOrder === "asc"){ return a.price - b.price;} else {return b.price - a.price}})

  return (
    // main container block
    <div className='container'> 
      <h1 className = "my-4"> Product Catalog</h1>
      <div className = "row align-items-center mb-4">
        {/* Category Filter block */}
        <div className='col-md-3 col-sm-12 mb-2'> 
            {/* CategoryFilter component */}
            <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
        </div>
        {/* Search Block */}
        <div className = "col-md-5 col-sm-12 mb-2">
            <input
            type = "text"
            className = "form-control"
            placeholder = "Search"
            value = {searchTerm}
            // on change event - updates the searchTerm state when the input value changes
            onChange = {handleSearchChange}
            >
            </input>
        </div>
        {/* Sort Order Block */}
        <div className='col-md-4 col-sm-12 mb-2'>
            <select className = 'form-control' onChange={handleSortChange}>
                {/* order sort options */}
            <option value = "asc">Sort by Price: Low to High</option>
            <option value = "desc">Price: High to Low</option>
            </select>
        </div>
      </div>  
         {/* Product list block */}
          <div>
            {filteredProducts.length ? (
              // displays products filtered by certain category 
              <ProductList products={filteredProducts} />
            ) :
            // in other case displays no products found message
            (<p>No products found</p>)
            }
          </div>
    </div>
  )
}

// exports the main app component
export default App
