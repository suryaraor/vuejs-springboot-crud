<template>
  <form @submit="onSubmit" class="add-form">
    <div class="form-control">
      <label>Product</label>
      <input type="text" v-model="name" name="name" placeholder="Add Product" />
    </div>
    <div class="form-control">
      <label>Price</label>
      <input
        type="text"
        v-model="price"
        name="price"
        placeholder="Add Price"
      />
    </div>
    <div class="form-control form-control-check">
      <label>Quantity</label>
      <input
        type="text"
        v-model="quantity"
        name="quantity"
        placeholder="Add quantity"
      />

      <vue-number-input v-model="quantity" :min="1" :max="10" inline controls></vue-number-input>

    </div>

    <input type="submit" value="Save Product" class="btn btn-block" />
  </form>
</template>

<script>
export default {
  name: 'AddProduct',
  data() {
    return {
      name: '',
      price: '',
      quantity: 10,
    }
  },
  methods: {
    onSubmit(e) {
      e.preventDefault()

      if (!this.name) {
        alert('Please add a product')
        return
      }

      const newProduct = {
        // id: Math.floor(Math.random() * 100000),
        name: this.name,
        price: this.price,
        quantity: this.quantity,
      }

      this.$emit('add-product', newProduct)

      this.name = ''
      this.price = ''
      this.quantity = 10
    },
  },
}
</script>

<style scoped>
.add-form {
  margin-bottom: 40px;
}

.form-control {
  margin: 20px 0;
}

.form-control label {
  display: block;
}

.form-control input {
  width: 100%;
  height: 40px;
  margin: 5px;
  padding: 3px 7px;
  font-size: 17px;
}

.form-control-check {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.form-control-check label {
  flex: 1;
}

.form-control-check input {
  flex: 2;
  height: 20px;
}
</style>
