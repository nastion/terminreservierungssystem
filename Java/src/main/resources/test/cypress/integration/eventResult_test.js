/*
    Diese Testcases prüfen die Result Seite
*/
describe('Event Result Page', function() {
    
    /*
        Dieser Testcase ruft die Seite auf
    */
    it('Event Result aufrufen', function() {
      cy.visit('http://localhost/')             //URL muss noch geändert werden
    })

    /*
        Dieser Testcase prüft ob die Überschrift vorhanden ist
    */
    it('Event Result Ueberschriften pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //prüfen ob die Überschirft vorhanden ist:
        cy.contains('EventName')
        cy.contains('Votes')
      })
  })
