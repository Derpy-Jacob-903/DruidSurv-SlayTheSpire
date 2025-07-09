package druidsurv.cards.abilities;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractPowerCostCard;

import static druidsurv.ModFile.makeID;

public class SpiritStrike extends AbstractPowerCostCard {
    public final static String ID = makeID("SpiritStrike");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public SpiritStrike() {
        super(ID, 4, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY, "SpiritStrike");
        baseDamage = 20;
        tags.add(CardTags.STRIKE);
        setBackgroundTexture("druidsurvResources/images/512/hero_attack.png", "druidsurvResources/images/1024/hero_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.LIGHTNING);
        addToBot((AbstractGameAction)new GainEnergyAction(1));
    }

    @Override
    public void upp() {
        upgradeDamage(10);
    }
}