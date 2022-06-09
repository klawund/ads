## model.Product.java
- code : String
- description : String
- price : double
- transientQuantity : int

## model.Stock.java
- products : Map<product : Product, quantity : Integer>
---
+ createProduct(product : Product) : void
+ removeProduct(product : Product) : void
+ addEntry(product : Product) : void
+ getStockReport() : String
+ getProductStockQuantity(product : Product) : int
+ hasProduct(productCode : String) : boolean
+ getProductList() : List<Product>

## model.Shop.java
- stock : Stock
- saleLog : List<FiscalNote>
- saleResult : double
---
+ createProduct(product : Product) : void
+ removeProduct(product : Product) : void
+ addEntry(product Product : int) : void
+ addSaleLog(fiscalNote : FiscalNote) : void
+ generateSaleLog() : String
+ generateProductsSummary() : String

## model.FiscalNote.java
- saleDate : Date
- productDescription : String
- quantity : int
- totalPrice : double
---
+ FiscalNote(product : Product) : FiscalNote
+ toString() : String

## view.InputOutput.java
+ showError(message : String) : void
+ showMessage(message : String, title : String) : void
+ readInfo(message : String) : String

## control.ShopController.java
- shop : Shop
---
+ createProduct() : void
+ getStockReport() : void
+ addToStock() : void
+ sellProduct() : void
+ removeProduct() : void
+ generateSaleLog() : void

## Program.java
+ main(args : String[]) : void
