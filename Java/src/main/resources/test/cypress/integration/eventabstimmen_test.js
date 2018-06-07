describe('Event Abstimmen Page', function() {
    it('Event Abstimmen aufrufen', function() {
      cy.visit('http://localhost/')             //URL muss noch geändert werden
    })

    it('Event Abstimmen Ueberschriften pruefen', function() {
        cy.visit('http://localhost/')                   //URL richtig einfügen

        //prüfen ob die Überschirften vorhanden ist:
        cy.contains('EventName')
        cy.contains('Folgende Daten stehen zur Auswahl:')
      })
  })