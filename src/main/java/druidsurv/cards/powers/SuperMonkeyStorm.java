package druidsurv.cards.powers;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.PurgeField;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;

public class SuperMonkeyStorm extends AbstractEasyCard {
    public final static String ID = makeID("SuperMonkeyStorm");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SuperMonkeyStorm() {
        super(ID, 4, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL_ENEMY, "SuperMonkeyStorm_CardArt");
        PurgeField.purge.set(this, true);
        baseDamage = 30;
        baseMagicNumber = magicNumber = 6;
        this.exhaust = true;
        tags.add(druidsurv.cards.cardvars.CardTags.BCSPOWER);
        isMultiDamage = true;

        this.setCardBack(cardSubType.POWER);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        allDmg(AbstractGameAction.AttackEffect.LIGHTNING);
    }

    @Override
    public void upp() {
        upgradeDamage(9);
    }
}