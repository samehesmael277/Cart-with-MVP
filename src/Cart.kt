class Cart {
    private val products: MutableList<Product> = mutableListOf()

    fun addProduct(product: Product) {
        this.products.add(product)
    }

    fun removeProduct(product: Product) {
        this.products.remove(product)
    }

    fun increaseProductQty(productId: Int) {
        val newProducts = this.products.map { product ->
            if (product.id == productId) {
                product.copy(qty = product.qty + 1)
            } else {
                product
            }
        }
        this.products.clear()
        this.products.addAll(newProducts)
    }

    fun decreaseProductQty(productId: Int, qty: Int) {
        if (qty > 1) {
            val newProducts = this.products.map { product ->
                if (product.id == productId) {
                    product.copy(qty = product.qty - 1)
                } else {
                    product
                }
            }
            this.products.clear()
            this.products.addAll(newProducts)
        } else {
            this.products.removeIf { it.id == productId }
        }
    }

    fun getCartProducts(): List<Product> {
        return this.products
    }

    fun getProduct(productId: Int): Product? {
        return this.products.find { product ->
            product.id == productId
        }
    }
}