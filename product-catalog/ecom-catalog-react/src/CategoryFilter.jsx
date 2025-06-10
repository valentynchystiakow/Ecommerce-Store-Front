// creates CategoryFilter component
const CategoryFilter = ({categories, onSelect}) => {
    return (
        // category select block 
        <select id = 'categorySelect' className = "form-control" onChange={(e)=>onSelect(e.target.value)}>
            <option value = "">All categories</option>
            {categories.map(category => (<option key = {category.id} value = {category.id}>{category.name}</option>))}
        </select>
)
}

// exports ProductList component
export default CategoryFilter;
