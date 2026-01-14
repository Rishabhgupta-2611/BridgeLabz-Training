package libraryManagementSystem;

class Transaction {
	private Book book;
	private Member member;

	public Transaction(Book book, Member member) {
		this.book = book;
		this.member = member;
	}

	public void issue() throws BookNotAvailableException {
		book.issueBook();
		System.out.println();
		System.out.println("   Book : " + book.getTitle());
		System.out.println("   Issued To : " + member.name);
	}

	public void returnBook(int lateDays) {
		book.returnBook();
		double fine = member.calculateFine(lateDays);
		System.out.println();
		System.out.println("   Book : " + book.getTitle());
		System.out.println("   Returned By : " + member.name);
		System.out.println("   Late Days : " + lateDays);
		System.out.println("   Fine Amount : ₹" + fine);
	}
}
