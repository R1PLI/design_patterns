package java8.venkat.Assets;

import java8.venkat.Assets.bean.Asset;
import java8.venkat.Assets.bean.Asset.AssetType;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class App {
	public static void main(String[] args) {
		final List<Asset> assets = Arrays.asList(
			new Asset(AssetType.BOND, 1000),
			new Asset(AssetType.BOND, 2000),
			new Asset(AssetType.STOCK, 3000),
			new Asset(AssetType.STOCK, 4000)
		);

		System.out.println("Total of all assets: " + totalAssetValues(assets));
		System.out.println("Total of bond assets: " + totalBondValues(assets));
		System.out.println("Total of stock assets: " + totalStockValues(assets));

		System.out.println("------------------");

		System.out.printf("Total of all assets: %d%n", totalAssetValues(assets, asset -> true));
		System.out.printf("Total of bond assets: %d%n", totalAssetValues(assets, asset -> asset.getType() == AssetType.BOND));
		System.out.printf("Total of stock assets: %d%n", totalAssetValues(assets, asset -> asset.getType() == AssetType.STOCK));

	}

	public static int totalAssetValues(final List<Asset> assets) {
		return assets.stream()
			.mapToInt(Asset::getValue)
			.sum();
	}

	//don't ever do like that
	public static int totalBondValues(final List<Asset> assets) {
		return assets.stream()
			.mapToInt(asset ->
				asset.getType() == AssetType.BOND ? asset.getValue() : 0)
			.sum();
	}

	//and like that
	public static int totalStockValues(final List<Asset> assets) {
		return assets.stream()
			.mapToInt(asset ->
				asset.getType() == AssetType.STOCK ? asset.getValue() : 0)
			.sum();
	}

	//the best solution for combining these three methods
	public static int totalAssetValues(
		final List<Asset> assets, final Predicate<Asset> assetPredicate) {
		return assets.stream()
			.filter(assetPredicate)
			.mapToInt(Asset::getValue)
			.sum();
	}
}
