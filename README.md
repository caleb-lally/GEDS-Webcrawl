# GEDS Webcrawl


DEPENDENCIES: This project requires the latest version of Gson, accessible from the Maven repository.

PROJECT REQUIREMENTS:

1. Use Java, C#, Golang, or any other agreed upon language.
2. Use any frameworks/libraries you want.
3. Feel free to use the internet.
4. If you have to make a tradeoff between clean, maintainable code and a complete
solution in the time you’re able to spend, we would rather see clean code that
could be easily maintained by a team of developers.
5. We can discuss ideas you did not have time to implement when we review your
solution together.
6. Your solution should:
	a. Start with the first page in the list of pages and follow links to crawl the
remaining pages in the list.
	b. Visit each valid page in a JSON “Internet” exactly once. For example, if
more than one page has a link to p2, you should only have to parse p2
one time.
	c. Handle all the JSON “Internet” samples in the test data section.
	d. Employ parallelism/concurrency.
	e. Return (order not important):
		i. The list of page addresses it crawled successfully
		ii. The list of duplicate page addresses it skipped
		iii. The list of invalid page addresses it skipped

USER INSTRUCTIONS: Paste the desired .json of similar format to test cases into the webCrawl class.