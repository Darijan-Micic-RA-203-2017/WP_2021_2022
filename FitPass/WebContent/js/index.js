$(document).ready(function() {
    resolveAuthorizationButtons();
    
    var venues = [];
    
    $.ajax({
        type: 'GET',
        url: 'api/venues',
        dataType: 'json',
        success: function(retrievedVenues) {
            for (let v of retrievedVenues) {
                venues.push(v);
            }
            
            for (let venue of venues) {
                let newTableRow = $('<tr></tr>');
                
                let newTableHeader = $('<th></th>');
                newTableHeader.attr('scope', 'row');
                newTableHeader.text(venue['id']);
                newTableRow.append(newTableHeader);

                let newTableData = $('<td></td>');
                newTableData.text(venue['name']);
                newTableRow.append(newTableData);

                newTableData = getVenueType(venue['typeId']);
                newTableRow.append(newTableData);

                newTableData = resolveStatus(venue['status']);
                newTableRow.append(newTableData);
                
                newTableData = getLocation(venue['locationId']);
                newTableRow.append(newTableData);
                
                newTableData = resolveLogo(venue['logoPath']);
                newTableRow.append(newTableData);

                newTableData = $('<td></td>');
                newTableData.text(venue['averageGrade']);
                newTableRow.append(newTableData);

                newTableData = resolveWorkingHours(venue['workingHours']);
                newTableRow.append(newTableData);

                $('#venuesTable > tbody').append(newTableRow);
            }
        },
        error: function(message) {
            alert(message.responseText);
        }
    });
});

function resolveAuthorizationButtons() {
    $('#registrationAsABuyerButton').click(function() {
        window.location.href = 'registration.html';
    });
    
    $.ajax({
        type: 'GET',
        url: 'api/authorization/logged-user',
        dataType: 'json',
        success: function() {
            $('#loginButton').hide();
            
            $('#logoutButton').show();
            $('#logoutButton').removeAttr('hidden');
            $('#logoutButton').click(function() {
                $.ajax({
                    type: 'POST',
                    url: 'api/authorization/logout',
                    data: '',
                    success: function() {
                        alert('Korisnik je uspešno odjavljen!');
                        
                        window.location.href = 'index.html';
                    },
                    error: function(message) {
                        alert(message.responseText);
                    }
                });
            });
        },
        error: function() {
            $('#loginButton').show();
            $('#loginButton').removeAttr('hidden');
            $('#loginButton').click(function() {
                window.location.href = 'login.html';
            });
            
            $('#logoutButton').hide();
        }
    });
}

function getVenueType(typeId) {
    let venueTypeTableData = $('<td></td>');

    $.ajax({
        type: 'GET',
        url: 'api/venue-types/' + typeId,
        dataType: 'json',
        success: function(retrievedVenueType) {
            venueTypeTableData.text(retrievedVenueType['name']);
        },
        error: function(message) {
            alert(message.responseText);
        }
    });

    return venueTypeTableData;
}

function resolveStatus(status) {
    let statusTableData = $('<td></td>');

    if (status == 'WORKING') {
        statusTableData.text('Radi');
    } else if (status == 'NOT_WORKING') {
        statusTableData.text('Ne radi');
    }
    
    return statusTableData;
}

function getLocation(locationId) {
    let locationTableData = $('<td></td>');

    $.ajax({
        type: 'GET',
        url: 'api/locations/' + locationId,
        dataType: 'json',
        success: function(retrievedLocation) {
            locationTableData.text(retrievedLocation['latitude'] + '\n\n' + 
                retrievedLocation['longitude']);
        },
        error: function(message) {
            alert(message.responseText);
        }
    });

    return locationTableData;
}

function resolveLogo(logoPath) {
    let logoTableData = $('<td></td>');
    logoTableData.addClass('logoTableData');

    let logoElement = $('<img>');
    logoElement.addClass('img-fluid rounded mx-auto d-block');
    logoElement.attr('src', logoPath);
    logoElement.attr('alt', 'logo');

    logoTableData.append(logoElement);
    
    return logoTableData;
}

function resolveWorkingHours(workingHours) {
    let workingHoursTableData = $('<td></td>');
    workingHoursTableData.text(workingHours['openingHours'] + ' - ' + workingHours['closingHours']);
    
    return workingHoursTableData;
}
