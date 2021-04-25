ب دقیقاً یک حلقه ثابت برای حلقه for در سطرهای 2-4 بیان کنید و ثابت کنید که این حلقه ثابت است. مدرک شما باید از ساختار اثبات ثابت حلقه ارائه شده در این فصل استفاده کند.
        ب حلقه ثابت: در شروع هر تکرار حلقه for برای خطوط 2-4 ، زیر مجموعه A [j..n] A [j..n] از عناصر اصلی در A [j..n] A تشکیل شده است [ j..n] قبل از ورود به حلقه اما احتمالاً به ترتیب متفاوت و اولین عنصر A [j] A [j] کوچکترین در میان آنها است.

        مقداردهی اولیه: در ابتدا زیرآرایه فقط آخرین عنصر A [n] A [n] را شامل می شود که به طور پیش پا افتاده کوچکترین عنصر زیر مجموعه است.

        نگهداری: در هر مرحله A [j] A [j] را با A [j - 1] A [j − 1] مقایسه می کنیم و A [j - 1] A [j − 1] را کوچکترین در میان آنها قرار می دهیم. بعد از تکرار ، طول زیر مجموعه به یک افزایش می یابد و اولین عنصر کوچکترین زیر مجموعه است.

        Termination: حلقه زمانی خاتمه می یابد که j = ij = i. با توجه به بیانیه حلقه ، A [i] A [i] کوچکترین در میان A [i..n] A [i..n] و A [i..n] A [i..n] است قبل از ورود به حلقه ، عناصر موجود در A [i..n] A [i..n] هستند.