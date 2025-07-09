package druidsurv.cards.powers;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PurgeField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.CharacterFile;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class Firestorm extends AbstractEasyCard {
    public final static String ID = makeID("Firestorm");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public Firestorm() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY, CharacterFile.Enums.NEMDRUID_COLOR, "Firestorm_CardArt");
        baseDamage = 14;
        //this.exhaust = true;
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        isMultiDamage = true;
        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        allDmg(AbstractGameAction.AttackEffect.FIRE);
    }

    @Override
    public void upp() {
        upgradeDamage(9);
    }
}