/*
    Dieser Testcase testet die Event Abstimmen Seite
*/
describe('Event Abstimmen Page', function() {
    
    /*
        Dieser Testcase ruft die Seite auf
    */
    it('Event Abstimmen aufrufen', function() {
      cy.visit('http://localhost/')             //URL muss noch geändert werden
    })

    /*
        Dieser Testcase prüft ob die Überschrift vorhanden ist
    */
    it('Event Abstimmen Ueberschriften pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //prüfen ob die Überschirften vorhanden ist:
        cy.contains('EventName')
        cy.contains('Folgende Daten stehen zur Auswahl:')
      })
  })
