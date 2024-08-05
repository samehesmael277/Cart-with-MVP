class Screen {
    val milk = Product(id = 1, name = "milk", price = 100.0)
    val meal = Product(id = 2, name = "meal", price = 200.0)
    val endomy = Product(id = 3, name = "endomy", price = 15.0)

    val samehPresenter = object : Presenter {
        override fun onProductsChange(products: List<Product>) {
            println("sameh: $products")
        }

        override fun onQtyChange(product: Product?) {
            println("sameh: $product")
        }
    }
    val raneemPresenter = object : Presenter {
        override fun onProductsChange(products: List<Product>) {
            println("raneem: $products")
        }

        override fun onQtyChange(product: Product?) {
            println("raneem: $product")
        }
    }

    val sameh = User(samehPresenter)
    val raneem = User(raneemPresenter)

    fun startActions() {
        sameh.addProduct(milk)
        Thread.sleep(1000)
        raneem.addProduct(meal)

        Thread.sleep(2000)

        sameh.increaseProductQty(milk.id)
        Thread.sleep(1000)
        raneem.increaseProductQty(meal.id)

        Thread.sleep(2000)

        sameh.getProduct(milk.id)?.qty?.let { qty ->
            sameh.decreaseProductQty(
                milk.id,
                qty
            )
        }
        Thread.sleep(1000)
        raneem.getProduct(meal.id)?.qty?.let { qty ->
            raneem.decreaseProductQty(
                meal.id,
                qty
            )
        }
        Thread.sleep(1000)
        raneem.getProduct(meal.id)?.qty?.let { qty ->
            raneem.decreaseProductQty(
                meal.id,
                qty
            )
        }

        Thread.sleep(2000)

        println("sameh: ${sameh.getCartProducts()}")
        println("raneem: ${raneem.getCartProducts()}")
    }
}