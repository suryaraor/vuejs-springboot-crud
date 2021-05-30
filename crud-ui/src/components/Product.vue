<template>
  <div
    @dblclick="$emit('toggle-quantity', product.id)"
    :class="[product.quantity ? 'quantity' : '', 'product']"
  >
    <h3>
      {{ product.name }} ₹ {{ product.price }}
     <i @click="$emit('delete-product', product.id)"  class="fas fa-times"></i>
      
    </h3>
    <p></p>
  </div>
</template>

<script>
export default {
  name: 'Product',
  props: {
    product: Object,
    showAddProduct: Boolean
  }
}
</script>

<style scope>
.fas {
  color: red;
  align-items: flex-end;
}

.product {
  background: #f4f4f4;
  margin: 5px;
  padding: 10px 20px;
  cursor: pointer;
}

.product.quantity {
  border-left: 5px solid green;
}

.product h3 {
  display: flex;
  align-items: flex-start;
  justify-content: space-evenly;
}
</style>
