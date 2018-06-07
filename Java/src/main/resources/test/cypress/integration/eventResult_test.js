describe('Event Result Page', function() {
    it('Event Result aufrufen', function() {
      cy.visit('http://localhost/')             //URL muss noch geändert werden
    })

    it('Event Result Ueberschriften pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //prüfen ob die Überschirft vorhanden ist:
        cy.contains('EventName')
        cy.contains('Votes')
      })
  })