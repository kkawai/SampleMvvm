# sample-mvvm-android
Sample of MVVM Architecture of a basic commerce app

## Description

![screenshot](https://preview.ibb.co/fst4d5/Screen_Shot_2017_05_05_at_2_56_26_PM.png)

- Sample app that loads data from `all.json` which is stored in `assets`, and make the app look like the above screenshot.
- Written in a such way that data retrieval implementation can be easily replaced. For example, it is currenly loaded from `all.json` file but in the near future we might want to fetch the data from network.
- In the item cell view, it needs to display item image from `photo`, title from `name`, and price from `price`.
- JSON representation of Java classes are pre-defined. See `com.mercari.mercaritest.data.model.Item` and `com.mercari.mercaritest.data.model.Response`.
- Uses `item_price_background.xml` with a text style of `black_14_white`.
- Uses `regular_14_black_70op` text style.
- Uses [Dagger](https://google.github.io/dagger/)
- Uses [RxJava](https://github.com/ReactiveX/RxJava)
- Displays `sold.png` as shown when `Item.status` equals to `sold_out`.
- Code is "production ready" level
- Has basic unit tests

