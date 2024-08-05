class User(private val presenter: Presenter) {
    private val cart: Cart = Cart()

    fun getCartProducts(): List<Product> {
        return this.cart.getCartProducts()
    }

    fun addProduct(product: Product) {
        this.cart.addProduct(product)
        presenter.onProductsChange(this.cart.getCartProducts())
    }

    fun removeProduct(product: Product) {
        this.cart.removeProduct(product)
        presenter.onProductsChange(this.cart.getCartProducts())
    }

    fun increaseProductQty(productId: Int) {
        this.cart.increaseProductQty(productId)
        presenter.onQtyChange(this.cart.getProduct(productId))
    }

    fun decreaseProductQty(productId: Int, qty: Int) {
        this.cart.decreaseProductQty(productId, qty)
        presenter.onQtyChange(this.cart.getProduct(productId))
    }

    fun getProduct(productId: Int): Product? {
        return this.cart.getProduct(productId)
    }
}