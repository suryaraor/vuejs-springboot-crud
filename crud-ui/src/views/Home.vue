<template>
  <AddProduct v-show="showAddProduct" @add-product="addProduct" />
  <Products
    @toggle-quantity="toggleReminder"
    @delete-product="deleteProduct"
    :products="products"
  />
</template>

<script>
import Products from '../components/Products'
import AddProduct from '../components/AddProduct'
export default {
  name: 'Home',
  props: {
    showAddProduct: Boolean,
  },
  components: {
    Products,
    AddProduct,
  },
  data() {
    return {
      products: [],
    }
  },
  methods: {
    async addProduct(product) {
      const res = await fetch('api/addProduct', {
        method: 'POST',
        headers: {
          'Content-type': 'application/json',
        },
        body: JSON.stringify(product),
      })

      const data = await res.json()

      this.products = [...this.products, data]
    },
    async deleteProduct(id) {
      if (confirm('Are you sure?')) {
        const res = await fetch(`api/deleteProduct/${id}`, {
          method: 'DELETE',
        })

        res.status === 200
          ? (this.products = this.products.filter((product) => product.id !== id))
          : alert('Error deleting product')
      }
    },
    async toggleReminder(id) {
      const productToToggle = await this.fetchProduct(id)
      const updProduct = { ...productToToggle, quantity: !productToToggle.quantity }

      const res = await fetch(`api/updateProduct`, {
        method: 'PUT',
        headers: {
          'Content-type': 'application/json',
        },
        body: JSON.stringify(updProduct),
      })

      const data = await res.json()

      this.products = this.products.map((product) =>
        product.id === id ? { ...product, quantity: data.quantity } : product
      )
    },
    async fetchProducts() {
      const res = await fetch('api/products')

      const data = await res.json()

      return data
    },
    async fetchProduct(id) {
      const res = await fetch(`api/product/${id}`)

      const data = await res.json()

      return data
    },
  },
  async created() {
    this.products = await this.fetchProducts()
  },
}
</script>
