<template>
  <div :key="product.id" v-for="product in products">
    <Product
      @toggle-quantity="$emit('toggle-quantity', product.id)"
      @delete-product="$emit('delete-product', product.id)"
      @edit-product="$emit('edit-product', product.id)"
      :product="product"
    />
  </div>
</template>

<script>
import Product from './Product'

export default {
  name: 'Products',
  props: {
    products: Array,
    showAddProduct: Boolean
  },
  components: {
    Product
  },
  emits: ['delete-product', 'edit-product', 'toggle-quantity']
}
</script>
