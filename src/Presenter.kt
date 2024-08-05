interface Presenter {
    fun onProductsChange(
        products: List<Product>
    )

    fun onQtyChange(
        product: Product?
    )
}