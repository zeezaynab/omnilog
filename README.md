# Omnilog: IP and URL Analysis Tool

Omnilog is a Java-based application developed to simplify the analysis of IP addresses and URLs. This project leverages web scraping techniques using Jsoup for gathering IP and URL information from whois.com, and utilizes JSON for handling HTTP communication with the ipinfo.io RESTful API. The graphical interface is built using JavaFX, and the development environment used is IntelliJ IDEA.

## Features

- **IP Logger:**
  - Gather detailed information such as CIDR, ISP provider, net type, and registration dates from whois.com.
  - Utilize web scraping techniques with Jsoup to automate data retrieval.
  
- **Geolocation:**
  - Retrieve precise coordinates, postal address, city, region, and country details of IPs using the ipinfo.io API.
  - Note: Geolocation data reflects the IP's routing path rather than the physical location of the user, influenced by ISP routing practices.
  
- **URL Analyzer:**
  - Explore domain details including registrar information, state, country, registration and expiration dates effortlessly.
  - JSON is employed to handle HTTP requests and responses with the ipinfo.io API.

## Technologies Used

- JavaFX: Graphical user interface development.
- Jsoup: Java library for web scraping and HTML parsing.
- JSON: Lightweight data interchange format for handling HTTP communication.
- IntelliJ IDEA: Integrated Development Environment for Java.

## Installation

1. Clone the repository from GitHub:
   ```
   git clone https://github.com/zeezaynab/omnilog.git
   ```
   
2. Open the project in IntelliJ IDEA or your preferred Java IDE.

3. Configure dependencies if necessary (JavaFX, Jsoup).

## Usage

1. Run the application from your IDE.
2. Enter an IP address or URL to initiate analysis.
3. Explore detailed insights retrieved from whois.com and ipinfo.io.

## Contributions
## Contributors

- [@zeezaynab](https://github.com/zeezaynab) - Co-author
- [@Zojaja-Naveed](https://github.com/Zojaja-Naveed) - Co-author


Contributions to Omnilog are welcome! If you have ideas for enhancements or find any issues, please submit them via GitHub issues.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
