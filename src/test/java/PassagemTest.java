// 1 - biblioteca / imports
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

// 2 - Classe
public class PassagemTest {

    // 2.1 - Atributos
    private WebDriver driver; // objeto do Selenium

    // 2.2 - Funções e Métodos //

    // Ante do Teste
    @BeforeEach
    public void iniciar() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // instanciar o objeto do Selenium como ChromeDriver
        driver.manage().window().maximize(); // maximiza a janela do browser
    }

    // Depois do Teste
    @AfterEach
    public void finalizar() {
        driver.quit(); // destroi o objeto do selenium
    }

    // Teste
    @Test
    public void comprarPassagem() {
        driver.get("https://www.blazedemo.com"); // abre o site
        // Seleciona origem, destino e aperta botão "Fing Flights"
        driver.findElement(By.name("fromPort")).click(); // clica no combo
        {
            WebElement dropdown = driver.findElement(By.name("fromPort"));
            dropdown.findElement(By.xpath("//option[. = 'São Paolo']")).click();
        }


        // Combo Destino
        {
            WebElement dropdown = driver.findElement(By.name("toPort"));
            dropdown.click();
            dropdown.findElement(By.xpath("//option[. = 'Cairo']")).click();
        }


        // Clicar no botão
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();



        // Transição de Página//



        // Verifica se foi selecionado minha cidade.
        assertEquals("Flights from São Paolo to Cairo:",
                driver.findElement(By.cssSelector("h3")).getText());

        // Clica no botão de voo desejado.
        driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();

        // Verifica se entrou no agendamento de voo correto
        assertEquals("Your flight from TLV to SFO has been reserved.",
                driver.findElement(By.cssSelector("h2")).getText());

    } // Final do comprarPassagem

} // Final da classe PassagemTest